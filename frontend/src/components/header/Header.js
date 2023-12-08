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
                    <div id="header-button" onClick={() => navigate("/account.html", {state: {username}})}>My account</div> 
                    <div id="header-button" onClick={handleLogOut}>Log out</div>
                </>) 
                : (
                    <>
                        <a href="create_account.html">Create account</a> 
                        <a href="login.html">Log in</a>
                    </>
                )
            }
        </header>
    );
}

export default Header;