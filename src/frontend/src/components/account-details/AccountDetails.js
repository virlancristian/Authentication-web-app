import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

import messages from '../../cache/api-messages';

import '../../css/account-details.css';

const AccountDetails = ({ username }) => {
    const INTERNAL_IP = process.env.REACT_APP_INTERNAL_IP;
    const navigate = useNavigate();
    
    const [account, setAccount] = useState({});
    const [isEditable, setEditable] = useState(false);
    const [newAccount, setNewAccount] = useState({
        oldUsername: username,
        newUsername: null,
        profilePictureURL: null,
        about_me: null,
        oldPassword: null,
        newPassword: null,
        newPasswordConfirm: null
    });

    const openFileExplorer = () => {
        const uploadImageInput = document.querySelector('.profile-picture-content input');

        uploadImageInput.click();
    }

    const uploadImage = async () => {
        const uploadImageInput = document.querySelector('.profile-picture-content input');
        let requestBody = new FormData();

        requestBody.append('image', uploadImageInput.files[0]);

        const response = await fetch(`http://${INTERNAL_IP || `localhost`}:8080/api/account/pfp/upload?username=${username}`, {
            method: 'POST',
            body: requestBody
        });
        const data = await response.text();

        if(response.status !== 200) {
            window.alert(data);
        } else {
            newAccount.profilePictureURL = `http://${INTERNAL_IP || `localhost`}:8080/api/account/pfp/get?imageName=${data}`;
            modifyAccount();
        }
    }

    const changeRequestBody = (event) => {
        const {id} = event.target;

        setNewAccount((prevAccount) => ({
            ...prevAccount,
            [id]: event.target.innerText
        }));
    }

    const modifyAccount = () => {
        fetch(`http://${INTERNAL_IP || 'localhost'}:8080/api/account/edit`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newAccount)
        }).then(response => response.json())
        .then(data => {
            window.alert(messages[data]);
            
            if(data === 'OPERATION_SUCCESSFUL') {
                navigate("/account.html", {state: {"username": newAccount.newUsername != null ? newAccount.newUsername : username}});
                window.location.reload();
            }
        })
        .catch(error => {
            console.log(error);
        })
    };

    const toggleEditable = () => {
        setEditable(!isEditable);

        if(isEditable) {
            modifyAccount();
        }
    }

   useEffect(() => {
    const requestAccount = () => {
        fetch(`http://${INTERNAL_IP || 'localhost'}:8080/api/account?username=${username}`)
        .then(response => response.json())
        .then(data => {
            setAccount(data);
        });
    }

    requestAccount();
   }, [username, INTERNAL_IP]);

    return (
        <div className="account-details-content">
            <div className="profile-picture-content">
                <img src={account.profilePictureURL} alt=""></img>
                <p onClick={openFileExplorer}>Change profile picture</p>
                <input type="file" onChange={uploadImage}></input>
            </div>
            <div className="other-account-details">
                <div className="username">Username: 
                        <div contentEditable={isEditable} id="newUsername" onKeyUp={changeRequestBody}>{account.username}</div>
                </div>
                <div className="about-me-title">About me</div>
                    <div className="about-me" contentEditable={isEditable} id="about_me" onKeyUp={changeRequestBody}>{account.about_me}</div>
                <div className="account-modification-buttons">
                    <div className="edit-profile-button" onClick={toggleEditable}>
                        {
                            isEditable ? 
                            "Save changes" :
                            "Edit profile"
                        }
                    </div>
                    <div className="change-password-button" onClick={() => navigate("/change_password.html", {state: {"username": username}})}>Change password</div>
                </div>
            </div>
        </div>
    );
}

export default AccountDetails;