/**
 * Json 工具
 * Created by Jin on 2017/7/4.
 */
export default {

    /**
     * 获取 Json 对象某一节点下的内容（不含节点本身）
     * @param obj Json对象
     * @param nameKey 节点
     * @returns {*} Json对象
     */
    getChild(obj, nameKey){
        let result = {};
        for (let key in obj) {
            let value = obj[key];
            if (key === nameKey) {
                return value;
            } else {
                if (typeof value === 'object') {
                    result = this.getChild(value, nameKey);
                }
            }
        }
        return result;
    },

    /**
     * 获取 Json 对象所有字段名为 nameKey 的内容（慎用）
     * @param obj
     * @param nameKey
     * @returns {Array} 包含全部内容的数组
     */
    getChildren(obj, nameKey) {
        let result = [];
        this.traverseChildren(result, obj, nameKey);
        console.log(result);
        return result;
    },

    traverseChildren(result, obj, nameKey) {
        if (typeof obj !== 'object') {
            return;
        }
        for (let key in obj) {
            let value = obj[key];
            if (key === nameKey) {
                result.push(value);
            } else {
                if (typeof value === 'object') {
                    this.traverseChildren(result, value, nameKey);
                }
            }
        }
    }


}
