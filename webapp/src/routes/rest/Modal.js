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
    // onSelectFilterChange(value);
    console.log('handleChange');
  }
  const onSearch = (value, typeName) => {
    console.log('val', value, typeName);
    onSelectFilterChange(value,typeName);
  }

  const getItem = (item, refType, val) => {
    switch(item){
      case 'InputNumber':{
        return <InputNumber />  
      }
      case 'Select':{
        console.log('select value:', item.menusList)
        
        if ('multiple' === val){
          return <Select
            mode='multiple'
            multiple='false'
            labelInValue
            placeholder="选择"
            notFoundContent={null}
            filterOption={false}
            onSearch={(val)=>{onSearch(val, refType)}}
            onFocus={(val)=>{onSearch('', refType)}}
            style={{ width: '100%' }}
          >
            {selectData.map(d => <Select.Option key={d.key}>{d.label}</Select.Option>)}
          </Select>
        }else{
          return <Select
            showSearch
            style={{ width: 200 }}
            placeholder="选择"
            optionFilterProp="children"
            onFocus={(val)=>{onSearch('', refType)}}
            filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
          >
            {selectData.map(d => <Select.Option key={d.key} value={d.key}>{d.label}</Select.Option>)}
          </Select>
        }
      }
      case 'Radio':{
        let v = JSON.parse(val);
        return (<Radio.Group>
                  {v.map((item,index)=>{
                    return <Radio value={item.val} key={index} >{item.text}</Radio>  
                  })}
                </Radio.Group>)
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
          let key = (col.itemType === 'Select' && col.itemValue === 'multiple')?col.dataIndex + "List" : col.key;
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
