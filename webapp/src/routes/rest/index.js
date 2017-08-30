import React from 'react'
import PropTypes from 'prop-types'
import { routerRedux } from 'dva/router'
import { connect } from 'dva'
import { Row, Col, Button, Popconfirm } from 'antd'
import List from './List'
import Filter from './Filter'
import Modal from './Modal'

const Rest = ({ location, dispatch, rest, loading }) => {
  const { list, pagination, currentItem, modalVisible, modalType, isMotion, selectedRowKeys,modalName } = rest
  const { pageSize } = pagination

  const modalProps = {
    item: modalType === 'create' ? {} : currentItem,
    visible: modalVisible,
    maskClosable: false,
    confirmLoading: loading.effects['rest/update'],
    title: `${modalType === 'create' ? 'Create ' : 'Update '}` + modalName,
    wrapClassName: 'vertical-center-modal',
    onOk (data) {
      dispatch({
        type: `rest/${modalType}`,
        payload: {modalName:modalName, data:data},
      })
    },
    onCancel () {
      dispatch({
        type: 'rest/hideModal',
      })
    },
  }

  const listProps = {
    dataSource: list,
    loading: loading.effects['rest/query'],
    pagination:{...pagination, showTotal: total => `共 ${total} 条`},
    location,
    isMotion,
    onChange (page) {
      const { query, pathname } = location
      dispatch(routerRedux.push({
        pathname,
        query: {
          ...query,
          pageNumber: page.current,
          pageSize: page.pageSize,
        },
      }))
    },
    onDeleteItem (id) {
      dispatch({
        type: 'rest/delete',
        payload: {data:id,modalName:modalName}
      })
    },
    onEditItem (item) {
      dispatch({
        type: 'rest/showModal',
        payload: {
          modalType: 'update',
          data:item,
          modalName:modalName,
        },
      })
    },
    rowSelection: {
      selectedRowKeys,
      onChange: (keys) => {
        dispatch({
          type: 'rest/updateState',
          payload: {
            selectedRowKeys: keys,
          },
        })
      },
    },
  }

  const filterProps = {
    isMotion,
    filter: {
      ...location.query,
    },
    onFilterChange (value) {
      dispatch(routerRedux.push({
        pathname: location.pathname,
        query: {
          ...value,
          pageNumber: 1,
          pageSize,
        },
      }))
    },
    onSearch (fieldsValue) {
      fieldsValue.keyword.length ? dispatch(routerRedux.push({
        pathname: '/rest',
        query: {
          field: fieldsValue.field,
          keyword: fieldsValue.keyword,
        },
      })) : dispatch(routerRedux.push({
        pathname: '/rest',
      }))
    },
    onAdd () {
      dispatch({
        type: 'rest/showModal',
        payload: {
          modalType: 'create',
          modalName: modalName
        },
      })
    },
    switchIsMotion () {
      dispatch({ type: 'rest/switchIsMotion' })
    },
  }

  const handleDeleteItems = () => {
    dispatch({
      type: 'rest/multiDelete',
      payload: {
        ids: selectedRowKeys,
        modalName: modalName
      },
    })
  }

  return (
    <div className="content-inner">
      <Filter {...filterProps} />
      {
        selectedRowKeys.length > 0 &&
        <Row style={{ marginBottom: 24, textAlign: 'right', fontSize: 13 }}>
          <Col>
            {`已选择 ${selectedRowKeys.length} 记录 `}
            <Popconfirm title={'您确定删除这些记录吗?'} placement="left" onConfirm={handleDeleteItems}>
              <Button type="primary" size="large" style={{ marginLeft: 8 }}>删除</Button>
            </Popconfirm>
          </Col>
        </Row>
      }
      <List {...listProps} />
      {modalVisible && <Modal {...modalProps} />}
    </div>
  )
}

Rest.propTypes = {
  rest: PropTypes.object,
  location: PropTypes.object,
  dispatch: PropTypes.func,
  loading: PropTypes.object,
}

export default connect(({ rest, loading }) => ({ rest, loading }))(Rest)
