/**
 * Created by zhongfan on 2017/6/12.
 */
import React from 'react'
import PropTypes from 'prop-types'
import {
    Select,
    Input,
    Checkbox,
    SearchBar,
    Form,
    FormCell,
    Cells,
    Cell,
    CellHeader,
    CellBody,
    CellFooter,Popup,PopupHeader,Article,Button
} from 'react-weui/build/packages';
import PageAction from '../PageAction/PageAction';
import PageActions from '../PageAction/PageActions';
import {getLookupList} from '../../../services/utilization'

class MultiSelect extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        let props = this.props;
        console.log(props);

        return <Popup
            show={this.props.show}
            onRequestClose={props.handleCancelClick}
        >
            <div style={{height: '100vh', overflow: 'scroll'}}>
                <Form checkbox>
                    {props.dataSource.map((item,index) => (
                        <FormCell checkbox key={index}>
                            <CellHeader>
                                <CellHeader>
                                    <Checkbox className="checkbox"/>
                                </CellHeader>
                            </CellHeader>
                            <CellBody>
                                {item.display_name}
                            </CellBody>
                        </FormCell>
                    ))}
                </Form>
            </div>
            <PageActions>
                <PageAction onClick={props.handleCancelClick}>取消</PageAction>
                <PageAction onClick={props.handleOKClick} type="primary">确定</PageAction>
            </PageActions>
        </Popup>
    }
}

MultiSelect.propTypes = {
    show: PropTypes.bool,
    title: PropTypes.string,
    defaultValue: PropTypes.string,
    valueChange: PropTypes.func,
    handleOKClick: PropTypes.func,
    handleCancelClick: PropTypes.func,
    dataSource: PropTypes.array,
};

export default MultiSelect