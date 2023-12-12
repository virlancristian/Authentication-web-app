import { useLocation } from 'react-router-dom';

import Header from "../components/header/Header";
import AccountDetails from "../components/account-details/AccountDetails";

const Account = () => {
    const location = useLocation();
    const username = location.state?.username;

    return (
        <>
            <Header username={username} />
            <AccountDetails username={username}/>
        </>
    );
}

export default Account;