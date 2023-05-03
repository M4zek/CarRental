import React from 'react'
import { Wrapper } from "./Root.styles"
import AuthenticatedApp from "./AuthenticatedApp"
import UnauthenticatedApp from "./UnauthenticatedApp"

const Root = () => {

  const user = {
    name: 'Jan Kowalski'
  }

  return (
    <Wrapper>
      {user ? <AuthenticatedApp /> : <UnauthenticatedApp />}
    </Wrapper>
  )
}

export default Root
