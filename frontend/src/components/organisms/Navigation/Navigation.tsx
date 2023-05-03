import React from 'react'
import { Wrapper, Logo, LinksContainer, StyledLink } from './Navigation.styles'

import carLogo from '../../../assets/images/logo.svg'
import userAvatar from '../../../assets/images/avatar.svg'

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
      <div>
        <img src={userAvatar} alt="user avatar" />
        User
      </div>
    </Wrapper>
  )
}

export default Navigation