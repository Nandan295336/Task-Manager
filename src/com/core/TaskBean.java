package com.core;

import java.util.Date;

public class TaskBean {
	
	private String taskName,desc,tags;
	private Date plannedDate;
	private int priority;
	
	public TaskBean() {
		
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Date getPlannedDate() {
		return plannedDate;
	}

	public void setPlannedDate(Date plannedDate) {
		this.plannedDate = plannedDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TaskBean(String taskName, String desc, String tags, Date plannedDate, int priority) {
		super();
		this.taskName = taskName;
		this.desc = desc;
		this.tags = tags;
		this.plannedDate = plannedDate;
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((plannedDate == null) ? 0 : plannedDate.hashCode());
		result = prime * result + priority;
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskBean other = (TaskBean) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (plannedDate == null) {
			if (other.plannedDate != null)
				return false;
		} else if (!plannedDate.equals(other.plannedDate))
			return false;
		if (priority != other.priority)
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaskBean [taskName=" + taskName + ", desc=" + desc + ", tags=" + tags + ", plannedDate=" + plannedDate
				+ ", priority=" + priority + "]";
	}
	
	
	
}

