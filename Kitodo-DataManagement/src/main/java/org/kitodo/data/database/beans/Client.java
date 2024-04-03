/*
 * (c) Kitodo. Key to digital objects e. V. <contact@kitodo.org>
 *
 * This file is part of the Kitodo project.
 *
 * It is licensed under GNU General Public License version 3 or later.
 *
 * For the full copyright and license information, please read the
 * GPL3-License.txt file that was distributed with this source code.
 */

package org.kitodo.data.database.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import org.kitodo.data.database.persistence.ClientDAO;

@Entity
@Table(name = "client")
public class Client extends BaseBean {

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_x_listcolumn", joinColumns = {@JoinColumn(name = "client_id",
            foreignKey = @ForeignKey(name = "FK_client_id"))},
            inverseJoinColumns = {@JoinColumn(name = "column_id",
                    foreignKey = @ForeignKey(name = "FK_column_id"))})
    private List<ListColumn> listColumns;

    /**
     * Gets name.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name
     *            The name.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object instanceof Client) {
            Client client = (Client) object;
            return Objects.equals(this.getId(), client.getId());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    /**
     * Get listColumns.
     * @return
     *          ListColumns
     */
    public List<ListColumn> getListColumns() {
        initialize(new ClientDAO(), this.listColumns);
        if (Objects.isNull(this.listColumns)) {
            this.listColumns = new ArrayList<>();
        }
        return this.listColumns;
    }

    /**
     * Set listColumns.
     * @param columns
     *          ListColumns
     */
    public void setListColumns(List<ListColumn> columns) {
        this.listColumns = columns;
    }
}
