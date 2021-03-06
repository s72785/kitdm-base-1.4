/*
 * Copyright 2015 Karlsruhe Institute of Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.kit.dama.scheduler.api.trigger;

import edu.kit.dama.scheduler.api.impl.QuartzExpressionTrigger;
import edu.kit.dama.scheduler.api.impl.test.SimpleExpressionTrigger;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.eclipse.persistence.oxm.annotations.XmlNamedAttributeNode;
import org.eclipse.persistence.oxm.annotations.XmlNamedObjectGraph;
import org.eclipse.persistence.oxm.annotations.XmlNamedObjectGraphs;

/**
 * Root interface of all trigger adapter.
 *
 * @author wq7203
 */
@XmlNamedObjectGraphs({
    @XmlNamedObjectGraph(
            name = "simple",
            attributeNodes = {
                @XmlNamedAttributeNode(value = "id")
            }
    ),
    @XmlNamedObjectGraph(
            name = "default",
            attributeNodes = {
                @XmlNamedAttributeNode(value = "id"),
                @XmlNamedAttributeNode(value = "name"),
                @XmlNamedAttributeNode(value = "triggerGroup"),
                @XmlNamedAttributeNode(value = "priority"),
                @XmlNamedAttributeNode(value = "description"),
                @XmlNamedAttributeNode(value = "nextFireTime"),
                @XmlNamedAttributeNode(value = "startDate"),
                @XmlNamedAttributeNode(value = "endDate"),
                @XmlNamedAttributeNode(value = "expression")
            }
    )
})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({SimpleExpressionTrigger.class, QuartzExpressionTrigger.class})
public abstract class ExpressionTrigger extends JobTrigger {

    private Date startDate;
    private Date endDate;
    private String expression;

    /**
     * Sets the trigger start date.
     *
     * @param startDate the trigger start date.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the trigger start date.
     *
     * @return the start date of this trigger.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the trigger end date.
     *
     * @param endDate the trigger end date.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the trigger end date.
     *
     * @return the end date of this trigger.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the trigger expression.
     *
     * @param expression the trigger expression.
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * Gets the trigger expression.
     *
     * @return the expression of this trigger.
     */
    public String getExpression() {
        return expression;
    }
}
