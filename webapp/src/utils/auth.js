import cookie from 'react-cookie';

const KEY_TOKEN = 'token';

export default {
	token (token) {
		if (token){
			cookie.save(KEY_TOKEN, token, {path: '/'});	
		}

		let t = cookie.load(KEY_TOKEN);
		console.log('token', t);
	    return t ? t : '';
	},
	logout(){
		console.log('logout');
		cookie.remove(KEY_TOKEN, {path: '/'});
	}
}