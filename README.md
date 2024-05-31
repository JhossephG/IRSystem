# IRSystem

## Environment Variables

The following environment variables need to be set for the application to run properly:

- `DATABASE_URL`: The JDBC URL of the database.
- `DATABASE_USERNAME`: The database username.
- `DATABASE_PASSWORD`: The database password.

Example:

```sh
export DATABASE_URL="jdbc:mysql://localhost:3306/car_store"
export DATABASE_USERNAME="root"
export DATABASE_PASSWORD="your_secure_password"
