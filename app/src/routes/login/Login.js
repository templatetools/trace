import React from 'react'
import './Login.scss'
import {
    ButtonArea,
    Button,
    Cell,
    CellHeader,
    CellBody,
    Dialog,
    Form,
    FormCell,
    Input,
    Toast,
    Footer,
    FooterText
} from 'react-weui/build/packages';
import {Redirect} from 'react-router-dom'

class Login extends React.Component {

    constructor(props) {
        super(props);

        document.title = "登录";

        this.state = {
            username: '',
            password: '',
            showLoading: false,
            showAlert: false
        };
    }

    /**
     * 登录
     */
    login() {
        // let {username, password} = this.state;
        let {username, password} = {username: 'admin',
            password: 'admin',};

        if (!username) {
            this.props.showMessage('请输入账号');
            return;
        }
        if (!password) {
            this.props.showMessage('请输入密码');
            return;
        }

        this.setState({showLoading: true});
        this.props.login(username, password, ((message) => {
            this.setState({showLoading: false}, () => {
                this.props.history.replace('/');
            });
        }), ((message) => {
            this.setState({showLoading: false});
            this.props.showMessage(message);
        }))
    }

    handleFormSubmit(e) {
        e.preventDefault();
        this.login();
    }

    /**
     * 登录页面
     * @returns {XML}
     */
    renderLoginPage() {
        return (
            <div className="Login">
                <div className="page-logo">
                    <img src={require('../../../asset/login/logo@2x.png')}/>
                </div>
                <form onSubmit={this.handleFormSubmit.bind(this)}>
                    <Form>
                        <FormCell>
                            <CellHeader>
                                <img src={require('../../../asset/login/ico_account@2x.png')} className="icon-img"/>
                            </CellHeader>
                            <CellBody>
                                <Input
                                    value={this.state.username}
                                    onChange={(e) => {
                                        this.setState({username: e.target.value})
                                    }}
                                    placeholder="用户名"/>
                            </CellBody>
                        </FormCell>
                        <FormCell>
                            <CellHeader>
                                <img src={require('../../../asset/login/ico_password@2x.png')} className="icon-img"/>
                            </CellHeader>
                            <CellBody>
                                <Input
                                    type="password"
                                    value={this.state.password}
                                    onChange={(e) => {
                                        this.setState({password: e.target.value})
                                    }}
                                    placeholder="密码"/>
                            </CellBody>
                        </FormCell>
                    </Form>
                    <ButtonArea>
                        <Button type="submit" className="weui_btn_primary">登录</Button>
                    </ButtonArea>
                </form>
                <Toast icon="loading" show={this.state.showLoading}>Loading...</Toast>

                <Footer>
                    <FooterText>Relax V1.1.804</FooterText>
                </Footer>
            </div>
        );
    }

    render() {
        return this.renderLoginPage()
    }
}

export default Login;
