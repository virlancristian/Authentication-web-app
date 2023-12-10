import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import messages from '../../cache/api-messages';

import '../../css/change-password-form.css';

const ChangePasswordForm = ({ username }) => {
    const INTERNAL_IP = process.env.REACT_APP_INTERNAL_IP;
    const navigate = useNavigate();
    
    const [newAccount, setNewAccount] = useState({
        oldUsername: username,
        newUsername: null,
        profilePictureURL: null,
        about_me: null,
        oldPassword: null,
        newPassword: null,
        newPasswordConfirm: null
    });

    const changeRequestBody = (event) => {
        const {name, value} = event.target;

        setNewAccount((prevAccount) => ({
            ...prevAccount,
            [name]: value
        }));
    };

    const modifyAccount = () => {
        fetch(`http://${INTERNAL_IP}:8080/api/account/edit`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newAccount)
        }).then(response => response.json())
        .then(data => {
            window.alert(messages[data]);
            
            if(data === 'OPERATION_SUCCESSFUL') {
                navigate("/account.html", {state: {username: newAccount.newUsername || username}});
            }
        })
        .catch(error => {
            console.log(error);
        })
    };

    return (
        <div className="change-password-form">
            <div className="field" id="old-password">
                <p>Old password</p>
                <input type="password" name="oldPassword" value={newAccount.oldPassword} onChange={changeRequestBody}></input>
            </div>
            <div className="field" id="new-password">
                <p>New password</p>
                <input type="password" name="newPassword" value={newAccount.newPassword} onChange={changeRequestBody}></input>
            </div>
            <div className="field" id="new-password-confirm">
                <p>Confirm new password</p>
                <input type="password" name="newPasswordConfirm" value={newAccount.newPasswordConfirm} onChange={changeRequestBody}></input>
            </div>
            <div className="change-pass-button" onClick={modifyAccount}>Change password</div>
        </div>
    );
}

export default ChangePasswordForm;