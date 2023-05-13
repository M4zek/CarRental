import React from 'react'
import ReactDOM from 'react-dom/client'
import Root from './views/Root.tsx'
import './assets/styles/fonts.css'
import AppProviders from './providers/AppProviders.tsx'

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <AppProviders>
      <Root />
    </AppProviders>
  </React.StrictMode>,
)
