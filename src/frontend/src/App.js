import './App.css';
import {HashRouter} from "react-router-dom";
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Navbar from "./pages/Navbar";
import FeedbackForm from "./pages/FeedbackForm";
import NotFound from "./pages/NotFound";
import Home from "./pages/Home";
import Footer from "./pages/Footer";
import FeedbackSubmit from "./pages/FeedbackSubmit";

function App() {

  return (
      <HashRouter>
        <div className="App">
          <Navbar/>
         
           <div className="content">
            <FeedbackForm/>
            {/*<switch>

              <Route exact path='/'>
                <Home/>
              </Route>

              <Route path='/sendFeedback/:pnr/:uuid'>
                <FeedbackForm/>
              </Route>

              <Route path='/feedbackSubmit'>
                <FeedbackSubmit/>
              </Route>



            </switch>
      */}
          </div> 
          {/* <Footer/>  */}
        </div>
      </HashRouter>
  );
}

export default App;
