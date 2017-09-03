export default function render (col, field) {
	if ('boolean' === field.fieldType){
		col.render = function(text){return text? '是': '否'}
	}
}