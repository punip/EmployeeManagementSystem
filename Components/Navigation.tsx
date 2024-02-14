import { Navbar, Container, Nav } from "react-bootstrap"

const Navigation:React.FC = () => {
    return(<>
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="/">Home</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/employee">Employee</Nav.Link>
            <Nav.Link href="/department">Department</Nav.Link>  
          </Nav>
      </Container>
    </Navbar>
    </>)
}
export default Navigation