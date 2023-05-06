import { Wrapper, Logo, LinksContainer, StyledLink } from './Navigation.styles'
import UserDropdown from '../../atoms/UserDropdown/UserDropdown'
import carLogo from '../../../assets/images/logo.svg'

const Navigation = () => {

  const menu = [
    {
      name: "Mój profil",
      url: "my-profile",
    },
    {
      name: "Moje wypożyczenia",
      url: "my-rentals",
    },
    {
      name: "Wyloguj",
      url: "logout",
    },
  ]

  return (
    <Wrapper>
      <Logo to="/">
        <img src={carLogo} alt="CarRental logo" />
      </Logo>
      <LinksContainer>
        <StyledLink to="/cars">Samochody</StyledLink>
        <StyledLink to="/offer">Oferta</StyledLink>
        <StyledLink to="/informations">Informacje</StyledLink>
        <StyledLink to="/about-us">O nas</StyledLink>
      </LinksContainer>
      <UserDropdown menuItems={menu} />
    </Wrapper>
  )
}

export default Navigation