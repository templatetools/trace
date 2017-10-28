import React from 'react'
import moment from 'moment';
import 'moment/locale/zh-cn';
moment.locale('zh-cn');
import dateUtil from '../../utils/DateUtil'
import PropTypes from 'prop-types'
import { Form, Input, InputNumber, Radio, Modal, Cascader,Select,DatePicker } from 'antd'
const { TextArea } = Input;
const { MonthPicker, RangePicker } = DatePicker;

import city from '../../utils/city'
import UserRemoteSelect from '../../components/UserRemoteSelect'

const FormItem = Form.Item

const formItemLayout = {
  labelCol: {
    span: 6,
  },
  wrapperCol: {
    span: 14,
  },
}

const modal = ({
  item = {},
  onOk,
  onSelectFilterChange,
  selectData,
  form: {
    getFieldDecorator,
    validateFields,
    getFieldsValue,
  },
  ...modalProps
}) => {
  const handleOk = () => {
    validateFields((errors) => {
      if (errors) {
        return
      }
      const data = {
        ...getFieldsValue(),
        key: item.key,
      }
      // data.address = data.address.join(' ')
      modalProps.columns.map((col, index)=>{
        if ('DatePicker' === col.itemType || 'MonthPicker' === col.itemType){
          let val = moment(data[col.key]).format('x');
          console.log('update data', val);

           data[col.key]=val;
        }
        
      })
      
      onOk(data)
    })
  }

  const onSelect = (value) => {
    // onSelectFilterChange(value);
    console.log('onSelect', value);
  }
  const onSearch = (value, typeName,refField,refFilter) => {
    console.log('val', value, typeName,refField,refFilter);
    onSelectFilterChange(value,typeName,refField,refFilter);
  }

  const getItem = (item, refType, refField,refFilter, val) => {
    switch(item){
      case 'InputNumber':{
        return <InputNumber />  
      }
      case 'TextArea':{
        return <TextArea/>
      }
      case 'Select':{
        console.log('select value:', selectData)
        if ('static' === refType){
          let v = JSON.parse(val);
          return <Select
              showSearch
              labelInValue
              placeholder="选择"
            >
              {v.map(d => <Select.Option key={d.key}>{d.label}</Select.Option>)}
            </Select>
        }else{
          if ('multiple' === val){
            return <Select
              mode='multiple'
              labelInValue
              placeholder="选择"
              notFoundContent={null}
              filterOption={false}
              onSearch={(val)=>{onSearch(val, refType,refField,refFilter)}}
              onFocus={(val)=>{onSearch('', refType,refField,refFilter)}}
              style={{ width: '100%' }}
            >
              {selectData[refType]?selectData[refType].map(d => <Select.Option key={d.key}>{d.label}</Select.Option>):<Select.Option key='1' value='1'>选择</Select.Option>}
            </Select>
          }else{
            return <Select
              showSearch
              labelInValue
              placeholder="选择"
              optionFilterProp="children"
              onSelect={onSelect}
              onSearch={(val)=>{onSearch(val, refType,refField,refFilter)}}
              onFocus={(val)=>{onSearch(val, refType,refField,refFilter)}}
              filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
            >
              {selectData[refType]?selectData[refType].map(d => <Select.Option key={d.key}>{d.label}</Select.Option>):<Select.Option key='1' value='1'>选择</Select.Option>}
            </Select>
          }
        }
      }
      case 'Radio':{
        let v = JSON.parse(val);
        return (<Radio.Group >
                  {v.map((item,index)=>{
                    return <Radio value={item.val} key={index} >{item.text}</Radio>  
                  })}
                </Radio.Group>)
      }
      case 'DatePicker':{
        return (<DatePicker />)
      }
      case 'MonthPicker':{
        return (<MonthPicker />)
      }
      default:{
        return val?<Input type={val}/>:<Input/>
      }
      
    }
  }

  const modalOpts = {
    ...modalProps,
    onOk: handleOk,
    getItem:getItem
  }

  return (
    <Modal {...modalOpts}>
      <Form layout="horizontal">
      {
        modalOpts.columns.map((col, index)=>{
          console.log('column and item:', col, item);
          let key = col.key;
          let initValue = item[key];
          if (col.itemType === 'Select'){
            if (col.itemValue === 'multiple'){
                key += "List"
            }
            if (col.itemValue === 'combobox'){
              key += "SelectItem"
            }
            if (col.refType === 'static'){
              key += "SelectItem"
            }
            initValue = item[key]?item[key]:{key:'', label:''}; 
          }
          if (!col.insertable){
            return;
          }

          let itemOption = {
              rules: [
                col.rules
              ]
          }

          console.log('key and value', key, initValue);

          if (item.hasOwnProperty('id')){
              itemOption['initialValue'] = initValue;
              if ('DatePicker' === col.itemType || 'MonthPicker' === col.itemType){
                itemOption['initialValue'] = moment(dateUtil.datetimeFormat(initValue, col.itemValue), col.itemValue)
              }
          }
          if ('label' === col.itemType){
            return (<FormItem label={col.title} hasFeedback {...formItemLayout} key={index}><span className="ant-form-text">{initValue}</span></FormItem>)
            }else{
            return (<FormItem label={col.title} hasFeedback {...formItemLayout} key={index}>
              {getFieldDecorator(key, itemOption)(getItem(col.itemType,col.refType,col.refField,col.refFilter,col.itemValue))}
            </FormItem>)
          }
        })
      }
      </Form>
    </Modal>
  )
}

modal.propTypes = {
  form: PropTypes.object.isRequired,
  type: PropTypes.string,
  item: PropTypes.object,
  onOk: PropTypes.func,
}

export default Form.create()(modal)
