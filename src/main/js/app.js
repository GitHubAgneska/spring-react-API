

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');


//  create a React component
class App extends React.Component {

    constructor(props) {
		super(props);
		this.state = {customers: []};
    }
    
    // API invoked after React renders a component in the DOM
    componentDidMount() {
		client({method: 'GET', path: '/api/customers'}).done(response => {
			this.setState({customers: response.entity._embedded.customers});
		});
	}

    // API “draws” the component on the screen
	render() {
		return (
			<CustomerList customers={this.state.customers}/>
		)
	}

}


class CustomerList extends React.Component{
	render() {
		const customers = this.props.customers.map(customer =>
			<Customer key={customer._links.self.href} customer={customer}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Address</th>
					</tr>
					{customers}
				</tbody>
			</table>
		)
	}
}

class Customer extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.customer.firstName}</td>
				<td>{this.props.customer.lastName}</td>
				<td>{this.props.customer.address}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)