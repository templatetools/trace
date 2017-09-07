import React from 'react'
import PropTypes from 'prop-types'
import { Form, Input, InputNumber, Radio, Modal, Cascader,Select } from 'antd'
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
      onOk(data)
    })
  }

  const handleChange = (value) => {
    onSelectFilterChange(value);
  }
  const onSearch = (value, typeName) => {
    console.log('val', value, typeName);
    onSelectFilterChange(value);
  }

  const getItem = (item, refType, val) => {
    switch(item){
      case 'InputNumber':{
        return <InputNumber />  
      }
      case 'Select':{
        console.log('select value:', item.menusList)
        return <Select
        mode="multiple"
        labelInValue
        placeholder="选择"
        notFoundContent={null}
        filterOption={false}
        onSearch={(val)=>{onSearch(val, refType)}}
        onChange={handleChange}
        style={{ width: '100%' }}
      >
        {selectData.map(d => <Option key={d.key}>{d.label}</Option>)}
      </Select>
      }
      case 'Radio':{
        let v = JSON.parse(val);
        return (<Radio.Group>
                  {v.map((item,index)=>{
                    return <Radio value={item.val} key={index} >{item.text}</Radio>  
                  })}
                </Radio.Group>)
      }
      default:
        return <Input />
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
          let key = col.itemType === 'Select'?col.dataIndex + "List" : col.key;
          if (!col.insertable){
            return;
          }
          return (<FormItem label={col.title} hasFeedback {...formItemLayout} key={index}>
            {getFieldDecorator(key, {
              initialValue: item[key],
              rules: [
                col.rules,
              ],
            })(getItem(col.itemType,col.refType, col.itemValue))}
          </FormItem>)
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
