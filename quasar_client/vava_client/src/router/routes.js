import Main from 'layouts/Main'
import Users from 'pages/Users'


const routes = [
  {
    path: '/',
    component: Main,
    children: [
      // users page
      {
        path: '/',
        component: Users
        

      
      }
    ]
  }
]

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  })
}

export default routes
