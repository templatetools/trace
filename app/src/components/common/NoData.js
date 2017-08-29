/**
 * Created by qcm on 2017/8/2.
 */
import React from 'react'
import PropTypes from 'prop-types'

import order from '../../../asset/common/list@3x.png'
import message from '../../../asset/common/cooperation_msg_default.svg'
import assets from '../../../asset/common/assets@3x.png'


class NoData extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            remind: '暂无数据',
            src: order,
            show: this.props.src ? true : false,
        }
    }

    getSrc() {
        switch (this.props.src) {
            case 'message':
                return message;
                break
            case 'order':
                return order;
                break
            case 'assets':
                return assets;
                break
            default:
                return order;
                break
        }
    }

    render() {
        return (
            this.props.show
                ?
                <div style={{
                    paddingTop: (this.state.show ? 120 : 20),
                    height: '100%',
                    width: '100%',
                    background: 'transparent',
                }}>
                    {this.state.show ?
                        <div style={{textAlign: 'center'}}>
                            <img style={{
                                height: 148,
                            }} src={this.getSrc()}/>
                        </div>
                        : ''}

                    <div style={{textAlign: 'center'}}>{this.props.remind ? this.props.remind : this.state.remind}</div>
                </div>
                :
                <div></div>
        );
    }

}

NoData.propTypes = {
    show: PropTypes.bool,
    src: PropTypes.string,
    remind: PropTypes.string,
};

export default NoData;