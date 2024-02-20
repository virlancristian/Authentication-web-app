import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import messages from '../../cache/api-messages';
import formInputs from '../../cache/form-inputs';

const AccountCreateForm = () => {
    const PROVIDED_IP = process.env.REACT_APP_PROVIDED_IP;
    const navigate = useNavigate();

    const [account, setAccount] = useState({
        username: '',
        email: '',
        password: '',
        confirmPassword: ''
    });

    const changeRequestBody = (event) => {
        const {name, value} = event.target;

        setAccount((previousAccount) => ({
            ...previousAccount,
            [name]: value
        }));
    };

    const createAccountRequest = () => {
        fetch(`${PROVIDED_IP || 'http://localhost:8080'}/api/account/create`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(account)
        }).then(response => response.json())
        .then(data => {
            window.alert(messages[data]);

            if(data === 'OPERATION_SUCCESSFUL') {
                navigate("/", { state: { username: account.username} })
            }
        })
        .catch(error => {
            console.log(error);
        });
    };

    return (
        <div className="account-create-form">
            {
                Object.keys(account).map(key => (
                    <div className="field" key={key}>
                        <p>{formInputs[key]['text']}</p>
                        <input type={formInputs[key]['inputType']} name={key} value={account[key]} onChange={changeRequestBody}/>
                    </div>
                ))
            }
            <div className="field" id="create-account-button" onClick={createAccountRequest}>Create account</div>
        </div>
    );
}

export default AccountCreateForm;