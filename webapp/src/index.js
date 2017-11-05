import { message } from 'antd'
import dva from 'dva'
import createLoading from 'dva-loading'
import { browserHistory } from 'dva/router'
import validator from 'async-validator'
import 'babel-polyfill'




// 1. Initialize
const app = dva({
  ...createLoading({
    effects: true,
  }),
  history: browserHistory,
  onError (error) {
    message.error(error.message)
  },
})
// 2. Model
app.model(require('./models/app'))

// 3. Router
app.router(require('./router'))

// 4. Start
app.start('#root')

console.log('schema', validator);

validator.prototype.messages =  function messages(_messages) {

	  return {
	    'default': 'Validation error on field %s',
	    required: '%s 必填项',
	    'enum': '%s must be one of %s',
	    whitespace: '%s cannot be empty',
	    date: {
	      format: '%s date %s is invalid for format %s',
	      parse: '%s date could not be parsed, %s is invalid ',
	      invalid: '%s date %s is invalid'
	    },
	    types: {
	      string: '%s is not a %s',
	      method: '%s is not a %s (function)',
	      array: '%s is not an %s',
	      object: '%s is not an %s',
	      number: '%s is not a %s',
	      date: '%s is not a %s',
	      boolean: '%s is not a %s',
	      integer: '%s is not an %s',
	      float: '%s is not a %s',
	      regexp: '%s is not a valid %s',
	      email: '%s is not a valid %s',
	      url: '%s is not a valid %s',
	      hex: '%s is not a valid %s'
	    },
	    string: {
	      len: '%s must be exactly %s characters',
	      min: '%s must be at least %s characters',
	      max: '%s cannot be longer than %s characters',
	      range: '%s must be between %s and %s characters'
	    },
	    number: {
	      len: '%s must equal %s',
	      min: '%s cannot be less than %s',
	      max: '%s cannot be greater than %s',
	      range: '%s must be between %s and %s'
	    },
	    array: {
	      len: '%s must be exactly %s in length',
	      min: '%s cannot be less than %s in length',
	      max: '%s cannot be greater than %s in length',
	      range: '%s must be between %s and %s in length'
	    },
	    pattern: {
	      mismatch: '%s value %s does not match pattern %s'
	    },
	    clone: function clone() {
	      var cloned = JSON.parse(JSON.stringify(this));
	      cloned.clone = this.clone;
	      return cloned;
	    }
	  };
	
}
