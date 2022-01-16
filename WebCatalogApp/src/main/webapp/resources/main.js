let loginForm = document.querySelector('.login-form-container');
let registerForm = document.querySelector('.register-form-container');

document.querySelector('#login-btn').onclick = () =>{
  loginForm.classList.toggle('active');
}

document.querySelector('#close-login-btn').onclick = () =>{
  loginForm.classList.remove('active');
}

document.querySelector('#register-btn').onclick = () =>{
	
  registerForm.classList.toggle('active');
}

document.querySelector('#close-register-btn').onclick = () =>{
	loginForm.classList.remove('active');
  registerForm.classList.remove('active');
}
document.querySelector('#login-again').onclick = () =>{
  registerForm.classList.remove('active');
}


