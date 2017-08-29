import React from 'react'
import './Home.scss'
import SingleSelect from '../../components/common/cmdb/SingleSelect'

class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
          lookup_popUp:false,
          lookUpDataSource:[1,2,3,4]
        }
    }
    handleOKClick(){
        this.setState({lookup_popUp:false})
    }
    handleCancelClick() {
        this.setState({lookup_popUp:false})
    }
    searchChange() {

    }
    render() {
        return <div>
          <button onClick={e => this.setState({lookup_popUp:true})}>
              123
          </button>
          <br/>
          <h1>
              工时填报项目
          </h1>
          <SingleSelect show={this.state.lookup_popUp} dataSource={this.state.lookUpDataSource}
                        handleOKClick={this.handleOKClick.bind(this)}
                        handleCancelClick={this.handleCancelClick.bind(this)}
                        searchChange={this.searchChange.bind(this)} defaultValue=""
          />
        </div>
    }
}
export default Home
