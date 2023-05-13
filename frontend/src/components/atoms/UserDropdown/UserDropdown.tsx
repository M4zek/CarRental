import { useState, useRef, useEffect } from "react";
import { Link } from 'react-router-dom';
import { Container, Button, Dropdown, DropdownItem } from './UserDropdown.styles';
import userAvatar from '../../../assets/images/avatar.svg';
import { useAuth } from "../../../hooks/useAuth";

const UserDropdown = () => {

  const auth = useAuth();
  const user = auth.user;

  const fullName = user?.firstName + ' ' + user?.lastName;

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
        <DropdownItem>
          <Link to='/my-profile'>Mój profil</Link>
        </DropdownItem>
        <DropdownItem>
          <Link to='/my-rentals'>Moje wypożyczenia</Link>
        </DropdownItem>
        <DropdownItem>
          <Link to='/logout'>Wyloguj</Link>
        </DropdownItem>
      </Dropdown>
    </Container>
  );
};

export default UserDropdown;