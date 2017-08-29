/**
 * Created by zhongfan on 2017/5/16.
 */
import React from 'react'
import ReactDOM from 'react-dom'
import {HashRouter, Route, Redirect, withRouter} from 'react-router-dom'

import {
    Toptips
} from 'react-weui/build/packages';

import Login from './src/routes/login/Login'
import Home from './src/routes/home/Home'
import test from './src/routes/common/test'

import Auth from './src/models/Auth'

import Bundle from './src/utils/bundle'
import Loading from './src/components/common/Loading'

import 'weui'
import 'react-weui/build/packages'
import './global.scss'

function PrivateRoute({component: Component, isLogin, ...rest}) {
    return (
        <Route
            {...rest}
            render={(props) => isLogin
                ? <Component {...props} />
                : <Redirect to={{pathname: '/login', state: {from: props.location}}} />}
        />
    )
}

class Application extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            showMessage: false,
            messageType: 'warn',
            messageTimer: null,
            message: '',
            isLogin: true,
        }
    }
    componentDidMount() {

    }
    componentWillUnmount() {
        this.state.messageTimer && clearTimeout(this.state.messageTimer);
    }
    createComponent(component) {
        return (props) => (
            <Bundle load={component}>
                {
                    (Component) => {
                        if (Component) {
                            if (props.location.pathname == '/login') {
                                return <Component {...props} showMessage={this.handleMessage.bind(this)} login={this.login.bind(this)}/>
                            }else if (props.location.pathname == '/profile' || props.location.pathname == '/engineer/profile') {
                                return <Component {...props} showMessage={this.handleMessage.bind(this)} logout={this.logout.bind(this)}/>
                            }else {
                                return <Component {...props} showMessage={this.handleMessage.bind(this)}/>
                            }
                        }else {
                            return <Loading/>
                        }
                    }
                }
            </Bundle>
        )
    }

    handleMessage(message, type = "warn") {
        console.log(type);
        this.setState({message: message, messageType: type});
        this.showMessage()
    }
    showMessage() {
        if (this.state.showMessage) {
            this.state.messageTimer && clearTimeout(this.state.messageTimer);
            this.setState({showMessage: false});
        }
        this.setState({showMessage: true});
        this.state.messageTimer = setTimeout(() => {
            this.setState({showMessage: false});
        }, 2000);
    }

    logout(success, failure) {
        Auth.logout(() => {
            success();
            this.setState({isLogin: false});
        },() => {
            failure("退出失败")
        });
    }
    login(username, password, success, failure) {
        Auth.login(username, password, (() => {
            success("登录成功");
            this.setState({isLogin: true});
        }), ((message) => {
            failure("登录失败");
            this.setState({isLogin: false});
        }));
    }

    render() {
        return <HashRouter>
            <div className="app">
                <Toptips type={this.state.messageType} show={this.state.showMessage}> {this.state.message} </Toptips>

                <PrivateRoute isLogin={this.state.isLogin} exact path="/" component={this.createComponent(Home)}/>
                <Route path="/login" component={this.createComponent(Login)}/>
                <Route path="/test" component={this.createComponent(test)}/>

            </div>
        </HashRouter>
    }
}

export default withRouter(Application)

ReactDOM.render(<Application />, document.getElementById('root'));

if (module.hot) {
    module.hot.accept(function (err) {
        console.log('Accepting the updated library module!');
        console.log(err)
    })
}
