import logo from './logo.svg';
import './App.css';
import {useState} from "react";

function App() {
    const [response, setResponse] = useState("");

    async function getData() {
        try {
            const person = await fetch("http://localhost:5000/person");
            if (!person.ok) {
                throw new Error(`Response status: ${response.status}`);
            }
            const json = await person.json();
            console.log(json.firstname);
        } catch (error) {
            console.log(error.message);
        }
    }
    getData();

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                    Edit <code>src/App.js</code> and save to reload.
                </p>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
        </div>
    );
}

export default App;
