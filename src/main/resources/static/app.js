class App extends React.Component {
    state = {
        people:[]
    }

    componentDidMount = () => {
        axios.get('/people').then(
            (response) => {
                this.setState({
                    people:response.data
                })
            }
        )
    }

    createPerson = (event) => {
        event.preventDefault();
        axios.post(
            '/people',
            {
                name:this.state.newPersonName,
                email:this.state.newPersonEmail,
                password: this.state.newPersonPassword
            }
        ).then(
            (response) => {
                this.setState({
                    people:response.data
                })
            }
        )
    }

    changeNewPersonPassword = (event) => {
        this.setState({
            newPersonPassword:event.target.value
        });
    }

    changeNewPersonEmail = (event) => {
        this.setState({
            newPersonEmail:event.target.value
        });
    }

    changeNewPersonName = (event) => {
        this.setState({
            newPersonName:event.target.value
        });
    }

    deletePerson = (event) => {
        axios.delete('/people/' + event.target.value).then(
            (response) => {
                this.setState({
                    people:response.data
                })
            }
        )

    }

    updatePerson = (event) => {
        event.preventDefault();
        const id = event.target.getAttribute('id');
        axios.put(
            '/people/' + id,
            {
                name:this.state.updatePersonName,
                age:this.state.updatePersonAge,
            }
        ).then(
            (response) => {
                this.setState({
                    people:response.data,
                    name:'',
                    age:null,
                })
            }
        )
    }

    changeUpdatePersonName = (event) => {
        this.setState(
            {
                updatePersonName:event.target.value
            }
        )
    }

    changeUpdatePersonAge = (event) => {
        this.setState(
            {
                updatePersonAge:event.target.value
            }
        )
    }

    render = () => {
        return <div>
            <h2>Create Person</h2>
            <form onSubmit={this.createPerson}>
                <input onKeyUp={this.changeNewPersonName} type="text" placeholder="name" /><br/>
                <input onKeyUp={this.changeNewPersonEmail} type="text" placeholder="email" /><br/>
                <input onKeyUp={this.changeNewPersonPassword} type="password" placeholder="password" /><br/>
                <input type="submit" value="Create Account" />
            </form>
            <h2>List of People</h2>
            <ul>
                {
                    this.state.people.map(
                        (person, index) => {
                            return <li key={index}>

                                {person.name}: {person.email}: {person.password}

                                <button value={person.id} onClick={this.deletePerson}>DELETE</button>

                                <form id={person.id} onSubmit={this.updatePerson}>
                                    <input onKeyUp={this.changeUpdatePersonName} type="text" placeholder="name"/><br/>
                                    <input onKeyUp={this.changeUpdatePersonAge} type="number" placeholder="age"/><br/>
                                    <input type="submit" value="Update Person"/>
                                </form>
                            </li>
                        }
                    )
                }
            </ul>
        </div>
    }
}

ReactDOM.render(
    <App></App>,
    document.querySelector('main')
)
