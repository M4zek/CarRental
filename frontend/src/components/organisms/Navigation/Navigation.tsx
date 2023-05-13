import { Wrapper, Logo, LinksContainer, StyledLink } from './Navigation.styles'
import UserDropdown from '../../atoms/UserDropdown/UserDropdown'
import carLogo from '../../../assets/images/logo.svg'

const Navigation = () => {

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
      <UserDropdown />
    </Wrapper>
  )
}

export default Navigation