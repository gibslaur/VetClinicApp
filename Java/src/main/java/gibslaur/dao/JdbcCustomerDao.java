package gibslaur.dao;

import gibslaur.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcCustomerDao implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = null;
        String sql = "SELECT customer_id, customer_name, email, phone_number, customer_notes " +
                "FROM customer " +
                "WHERE customer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
        if (results.next()) {
            customer = mapRowToCustomer(results);
        }
        return customer;
    }

    public Customer mapRowToCustomer(SqlRowSet sqlRowSet) {
        Customer customer = new Customer();
        customer.setCustomerId(sqlRowSet.getInt("customer_id"));
        customer.setCustomerName(sqlRowSet.getString("customer_name"));
        customer.setPhoneNumber(sqlRowSet.getString("phone_number"));
        customer.setCustomerNotes(sqlRowSet.getString("customer_notes"));
        return customer;
    }

}
