/**
 * Created by zhongfan on 2017/5/24.
 */
import React, { Component } from 'react'

class Bundle extends Component {
    constructor(props) {
        super(props);
        this.state = {
            // short for "module" but that's a keyword in js, so "mod"
            mod: null
        }
    }

    componentDidMount() {
        console.log("componentDidMount")
        this.load(this.props)
    }

    componentWillReceiveProps(nextProps) {
        console.log("componentWillReceiveProps")
        if (nextProps.load !== this.props.load) {
            this.load(nextProps)
        }
    }

    load(props) {
        this.setState({
            mod: null
        })
        props.load((mod) => {
            this.setState({
                // handle both es imports and cjs
                mod: mod.default ? mod.default : mod
            })
        })
    }

    render() {
        return this.props.children(this.state.mod)
    }
}

export default Bundle