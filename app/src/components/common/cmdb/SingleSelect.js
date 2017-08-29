/**
 * Created by Jin on 2017/6/15.
 */
import React from 'react';
import PropTypes from 'prop-types'
import {
    CellBody,
    CellFooter,
    Cells,
    Form,
    FormCell,
    Radio,
    Popup,
    SearchBar,
} from 'react-weui/build/packages';
import './SingleSelect.scss'

import Page from '../page'
import PageAction from '../PageAction/PageAction';
import PageActions from '../PageAction/PageActions';

class SingleSelect extends React.Component {

    constructor(props) {
        super(props);

        this.searchValue = '';
        this.state={

            selectedItem:{}
        }
    }

    radioClick(item) {
        this.setState({selectedItem:item})
    }
    radioChecked(item) {
        let checked = false;
        if (this.state.selectedItem.display_name) {
            checked = item.id == this.state.selectedItem.id
        }else {
            checked = item.id == this.props.defaultValue
        }
        return checked
    }

    render() {
        let props = this.props;
        return <Popup
            className="SingleSelect"
            show={this.props.show}
            onRequestClose={e => {props.handleCancelClick()}}
        >
            <div style={{height: '100vh'}}>
                <SearchBar
                    ref="SearchBar"
                    onChange={value => {
                        this.searchValue = value;
                        props.searchChange(value)
                    }}
                    onSubmit={value => {
                        console.log(value)
                    }}
                    placeholder="搜索"
                    lang={{
                        cancel: '取消'
                    }}
                />
                <Page>
                    <Form radio>
                        {props.dataSource.map((item,index) => (
                            <FormCell radio key={index}>
                                <CellBody style={{whiteSpace: 'pre-wrap'}}>{item.display_name}</CellBody>
                                <CellFooter>
                                    <Radio name="radio1"
                                           checked={this.radioChecked(item)}
                                           onChange={this.radioClick.bind(this,item)}/>
                                </CellFooter>
                            </FormCell>
                        ))}
                    </Form>
                </Page>
                <PageActions>
                    <PageAction onClick={e => {
                        props.handleCancelClick();
                        this.refs.SearchBar.state.text = "";
                        this.setState({selectedItem:{}})
                    }}>取消</PageAction>
                    <PageAction onClick={e => {
                        props.handleOKClick(this.state.selectedItem);
                        this.refs.SearchBar.state.text = "";
                        this.setState({selectedItem:{}})
                    }} type="primary">确定</PageAction>
                </PageActions>
            </div>
        </Popup>
    }
}

SingleSelect.propTypes = {
    show: PropTypes.bool,
    title: PropTypes.string,
    defaultValue: PropTypes.string,
    searchChange: PropTypes.func,
    radioClick: PropTypes.func,
    handleSearchChange: PropTypes.func,
    handleOKClick: PropTypes.func,
    handleCancelClick: PropTypes.func,
    dataSource: PropTypes.array,
};

export default SingleSelect