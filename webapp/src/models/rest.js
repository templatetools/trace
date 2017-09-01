/* global window */
import modelExtend from 'dva-model-extend'
import pathToRegexp from 'path-to-regexp'
import { config } from 'utils'
import { query, create,remove, update } from 'services/rest'
import { pageColumnModel } from './common'
import { Link } from 'dva/router'
import { DropOption } from 'components'

const { prefix } = config

export default modelExtend(pageColumnModel, {
  namespace: 'rest',

  state: {
    currentItem: {},
    modalVisible: false,
    modalType: 'create',
    modalName:'',
    selectedRowKeys: [],
    isMotion: window.localStorage.getItem(`${prefix}userIsMotion`) === 'true',
  },

  subscriptions: {
    setup ({ dispatch, history }) {
      history.listen((location) => {
        console.log('rest', location.pathname);
        const match = pathToRegexp('/rest/:name').exec(location.pathname)
        if (match) {
          dispatch({ type: 'query', payload: { modalName: match[1], data:location.query } })
        }
      })
    },
  },

  effects: {

    * query ({ payload = {} }, { call, put }) {
      const data = yield call(query, payload)
      const columns = [
        {
          title: 'Avatar',
          dataIndex: 'avatar',
          key: 'avatar',
          width: 64,
          render: text => <img alt={'avatar'} width={24} src={text} />,
        }, {
          title: 'Name',
          dataIndex: 'name',
          key: 'name',
          render: (text, record) => <Link to={`user/${record.id}`}>{text}</Link>,
        }, {
          title: 'NickName',
          dataIndex: 'nickName',
          key: 'nickName',
        }, {
          title: 'Age',
          dataIndex: 'age',
          key: 'age',
        }, {
          title: 'Gender',
          dataIndex: 'isMale',
          key: 'isMale',
          render: text => (<span>{text
            ? 'Male'
            : 'Female'}</span>),
        }, {
          title: 'Phone',
          dataIndex: 'phone',
          key: 'phone',
        }, {
          title: 'Email',
          dataIndex: 'email',
          key: 'email',
        }, {
          title: 'Address',
          dataIndex: 'address',
          key: 'address',
        }, {
          title: 'CreateTime',
          dataIndex: 'createTime',
          key: 'createTime',
        }
      ]

      yield put({ type: 'updateState', payload: { modalName: payload.modalName } })

      if (data) {
        yield put({
          type: 'querySuccess',
          payload: {
            list: data.data.content,
            columns:columns,
            pagination: {
              current: Number(payload.pageNumber) || 1,
              pageSize: Number(payload.pageSize) || 10,
              total: data.data.totalPages,
            },
          },
        })
      }
    },

    * delete ({ payload }, { call, put, select }) {
      const data = yield call(remove, { data: payload.data, modalName: payload.modalName})
      const { selectedRowKeys } = yield select(_ => _.rest)
      if (data.success) {
        yield put({ type: 'updateState', payload: { selectedRowKeys: selectedRowKeys.filter(_ => _ !== payload) } })
        yield put({ type: 'query',payload:{modalName: payload.modalName,data:{}}})
      } else {
        throw data
      }
    },

    * multiDelete ({ payload }, { call, put }) {
      console.log('multiDelete', payload)
      const data = yield call(remove, {modalName: payload.modalName,data:payload.ids})
      if (data.success) {
        yield put({ type: 'updateState', payload: { selectedRowKeys: [] } })
        yield put({ type: 'query',payload:{modalName: payload.modalName,data:{}}})
      } else {
        throw data
      }
    },

    * create ({ payload }, { call, put }) {
      const data = yield call(create, payload)
      if (data.success) {
        yield put({ type: 'hideModal' })
        yield put({ type: 'query' ,payload:{modalName:payload.modalName,data:{}}})
      } else {
        throw data
      }
    },

    * update ({ payload }, { select, call, put }) {
      const id = yield select(({ rest }) => rest.currentItem.id)
      payload.data['id'] = id;
      const data = yield call(update, {modalName:payload.modalName,data:payload.data})
      if (data.success) {
        yield put({ type: 'hideModal' })
        yield put({ type: 'query',payload:{modalName:payload.modalName,data:{}}})
      } else {
        throw data
      }
    },

  },

  reducers: {

    showModal (state, { payload }) {
      return { ...state, ...payload, modalVisible: true }
    },

    hideModal (state) {
      return { ...state, modalVisible: false }
    },

    switchIsMotion (state) {
      window.localStorage.setItem(`${prefix}userIsMotion`, !state.isMotion)
      return { ...state, isMotion: !state.isMotion }
    },

  },
})
