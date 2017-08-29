/**
 * Created by zhongfan on 2017/6/13.
 */
import React from 'react';
import {
    Toast,
    Cells,
    CellsTitle,
    Cell,
    CellHeader,
    CellBody,
    CellFooter,
    Button,
    Icon,
    Flex,
    FlexItem,
    TextArea,
    Toptips
} from 'react-weui/build/packages';
import './test.scss'

//导入echarts
const echarts = require('echarts/lib/echarts'); //必须
//饼图
require('echarts/lib/chart/pie');
// 柱状图
require('echarts/lib/chart/bar');
//标题插件
require('echarts/lib/component/title');

import ReactTouchEvents from "react-touch-events";

class test extends React.Component {
    constructor(props) {
        super(props);
        this.state = {items: ['hello', 'world', 'click', 'me']};
        this.handleAdd = this.handleAdd.bind(this);
    }

    handleAdd() {
        const newItems = this.state.items.concat([
            prompt('Enter some text')
        ]);
        this.setState({items: newItems});
    }

    handleRemove(i) {
        let newItems = this.state.items.slice();
        newItems.splice(i, 1);
        this.setState({items: newItems});
    }

    render() {
        const items = this.state.items.map((item, i) => (
            <div key={item} onClick={() => this.handleRemove(i)}>
                {item}
            </div>
        ));

        return (
            <div className="test">
                <div className="div1">1111</div>
                <div className="div-2">2222</div>
                <div className="div-3">3333</div>
            </div>
        );
    }
}

export default test;