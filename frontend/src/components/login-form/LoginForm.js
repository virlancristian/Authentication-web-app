import { useNavigate } from 'react-router-dom';
import { useState } from 'react';

import messages from '../../cache/api-messages';
import formInputs from '../../cache/form-inputs';

import '../../css/login-form.css';

const LoginForm = () => {
    const navigate = useNavigate();
    const [account, setAccount] = useState({
        username: '',
        password: ''
    });

    const goHome = (username) => {
        navigate("/", { state: {username} })
    };

    const changeRequestBody = (event) => {
        const {name, value} = event.target;

        setAccount((prevAccount) => ({
            ...prevAccount,
            [name]: value
        }))
    };

    const loginRequest = () => {
        fetch(`http://localhost:8080/api/account/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(account)
        }).then(response => response.json())
        .then(data => {
            window.alert(messages[data]);

            if(data === 'OPERATION_SUCCESSFUL') {
                goHome(account.username);
            }
        })
        .catch(error => {
            console.log(error);
        });
    };

    return (
        <div className="login-form">
            {
                Object.keys(account).map(key => (
                    <div className="field" key={key}>
                        <p>{formInputs[key]['text']}</p>
                        <input type={formInputs[key]['inputType']} name={key} value={account[key]} onChange={changeRequestBody} />
                    </div>
                ))
            }
            <div className="login-button" onClick={() => loginRequest()}>
                Log in
            </div>
        </div>
    );
};

export default LoginForm;