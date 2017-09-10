import dateUtil from './DateUtil'

export default function render (col, field) {
	if ('Radio' === field.itemType){
		col.render = function(text){
			let values = JSON.parse(field.itemValue);
			for(let i = 0; i < values.length; i++){
				let val = values[i];
				if (text === val.val){
					return val.text;
				}
			}
		}
	}
	if ('DatePicker' === field.itemType){
		col.render = function(text){return dateUtil.datetimeFormat(text)}
	}
}