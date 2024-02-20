import { useNavigate } from 'react-router-dom';
import '../../css/header.css';

function Header({ username }) {
    const navigate = useNavigate();

    const handleLogOut = () => {
        navigate("/", {state: null});
    };

    return (
        <header>
            {
                username != null ? 
                (<>
                    <div id="header-button" onClick={() => navigate("/account", {state: {username}})}>My account</div> 
                    <div id="header-button" onClick={() => handleLogOut()}>Log out</div>
                </>) 
                : (
                    <>
                        <a href="create_account">Create account</a> 
                        <a href="login">Log in</a>
                    </>
                )
            }
        </header>
    );
}

export default Header;