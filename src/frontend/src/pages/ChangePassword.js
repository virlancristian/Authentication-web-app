import { useLocation } from 'react-router-dom';

import Header from '../components/header/Header';
import ChangePasswordForm from '../components/change-password-form/ChangePasswordForm';

const ChangePassword = () => {
    const location = useLocation();
    const username = location.state?.username || null;

    return (
        <>
            <Header username={username} />
            <ChangePasswordForm username={username} />
        </>
    );
}

export default ChangePassword;