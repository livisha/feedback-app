import { Link } from "react-router-dom"

const HelloWorld = () => {
    return (
        <div className="not-found">
            <h1>Sorry😭</h1>
            <h3>That Page cannot be found.</h3>
            <h4><b><Link to="/">Back to the HomePage....</Link></b></h4>
        </div>
    );
}

export default HelloWorld;