import { useState, useContext, useRef, useEffect } from "react";
import { AppContext } from '../../../views/Root';
import { Link } from 'react-router-dom';
import { Container, Button, Dropdown, DropdownItem } from './UserDropdown.styles';
import userAvatar from '../../../assets/images/avatar.svg';

const UserDropdown = ({ menuItems }) => {

  const { user } = useContext(AppContext);
  const fullName = user?.firstname + ' ' + user?.lastname;

  const [open, setOpen] = useState(false);
  const ref = useRef();

  const handleClickOutside = (event) => {
    if (ref.current && !ref.current.contains(event.target)) {
      setOpen(false);
    }
  };

  useEffect(() => {
    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);

  return (
    <Container ref={ref}>
      <Button onClick={() => setOpen(!open)}>
        <img src={userAvatar} alt="" />
        <span>
          {fullName}
        </span>
      </Button>
      <Dropdown open={open}>
        {menuItems.map((item) => {
          return (
            <DropdownItem>
              <Link to={item.url}>{item.name}</Link>
            </DropdownItem>
          );
        })}
      </Dropdown>
    </Container>
  );
};

export default UserDropdown;