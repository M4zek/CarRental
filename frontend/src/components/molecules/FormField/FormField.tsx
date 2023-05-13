import { StyledForm } from "./FormField.styles"

const FormField = ({handleSubmit, children}) => {

  return (
    <StyledForm as="form" onSubmit={handleSubmit}>
      {children}
    </StyledForm>
  )
}

export default FormField