import React from 'react'
import PropTypes from 'prop-types'
import { Form, Input, InputNumber, Radio, Modal, Cascader } from 'antd'
import city from '../../utils/city'

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
  const getItem = (item, val) => {
    switch(item){
      case 'InputNumber':{
        return <InputNumber />  
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
          console.log('column:', col);
          return (<FormItem label={col.title} hasFeedback {...formItemLayout} key={index}>
            {getFieldDecorator(col.key, {
              initialValue: item[col.dataIndex],
              rules: [
                col.rules,
              ],
            })(getItem(col.itemType,col.itemValue))}
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
