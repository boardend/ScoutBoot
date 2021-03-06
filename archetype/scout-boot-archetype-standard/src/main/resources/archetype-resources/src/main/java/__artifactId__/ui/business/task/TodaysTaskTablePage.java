#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui.business.task;

import ${package}.${artifactId}.model.Task;
import ${package}.${artifactId}.model.service.TaskService;
import ${package}.${artifactId}.ui.business.task.AbstractTaskTablePage.Table.AcceptMenu;

import java.util.Collection;
import javax.inject.Inject;

import org.eclipse.scout.rt.shared.TEXTS;

public class TodaysTaskTablePage extends AbstractTaskTablePage {

  @Inject
  private TaskService taskService;

  public TodaysTaskTablePage() {
    getTable().getResponsibleColumn().setDisplayable(false);
    getTable().getAcceptedColumn().setDisplayable(false);
    getTable().getDoneColumn().setDisplayable(false);
    getTable().getMenuByClass(AcceptMenu.class).setVisible(false);
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("TodaysTasks");
  }

  @Override
  protected Collection<Task> getTasks() {
    return taskService.getToday(getUserId());
  }

  @Override
  protected void execPageActivated() {
    reloadPage();
  }
}
