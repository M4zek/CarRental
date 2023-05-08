import React, { useContext, useEffect, useState } from 'react';
import axios from 'axios';

const AuthContext = React.createContext({});

export const AuthProvider = ({ children }) => {
  // const [user, setUser] = useState(null);

  const [user, setUser] = useState(() => {
    const savedUser = localStorage.getItem('user');
    return savedUser ? JSON.parse(savedUser) : null;
  });

  const [error, setError] = useState("");

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      (async () => {
        try {
          const response = await axios.get('/', {
            headers: {
              'Content-Type': 'application/json',
              'Authorization': 'Bearer ' + token,
            },
          });
          setUser(response.data);
        } catch (error) {
          console.log(error);
        }
      })();
    }
  }, []);

  const signIn = async ({ username, password }) => {
    
    if (!username || !password) {
      setError("Please provide both a login and a password.");
      return;
    }

    try {
      const response = await axios.post('http://localhost:8080/api/auth/authenticate', {
        username,
        password,
      });
      setUser(response.data);
      localStorage.setItem('token', response.data.token);
      localStorage.setItem('user', JSON.stringify(response.data));
    } catch (error) {
      if (error.response) {
        if (error.response.status === 401) {
          setError("Incorrect username or password.");
        } else if (error.response.status === 500) {
          setError("Server error.");
        } else {
          setError("An error has occurred.");
        }
      } else {
        setError("Network error.");
      }
    }
  };

  const logOut = () => {
    setUser(null);
    localStorage.removeItem('token');
    localStorage.removeItem('user');
  };

  return <AuthContext.Provider value={{ user, signIn, logOut, error }}>{children}</AuthContext.Provider>;
};

export const useAuth = () => {
  const auth = useContext(AuthContext);

  if (!auth) {
    throw Error('useAuth needs to be used inside AuthContext');
  }

  return auth;
};