import '../../css/home.css';

function Home({ username }) {
    return (
        <div className="content">
            {username != null
                ? (<><h1>Welcome {username}</h1></>)
                : (<><h1>Welcome, newcomer!</h1>
                    <p>Create an account or login to continue</p></>)
            }
        </div>
    );
}

export default Home;