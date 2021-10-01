import {Link} from "react-router-dom";
import {MdFeedback} from "react-icons/all";
import FeedbackList from "./FeedbackList";
import useFetch from "./useFetch";

const Home = () => {

    const { data : feedbacks, isPending, error} = useFetch('http://localhost:8081/feedbacks');

    return (
        <div className="home">
            { error && <div>{ error }</div>}
            { isPending && <div>Loading.....</div>}
            { !error && feedbacks && <FeedbackList feedbacks={feedbacks}/>}
        </div>
    );
}

export default Home;