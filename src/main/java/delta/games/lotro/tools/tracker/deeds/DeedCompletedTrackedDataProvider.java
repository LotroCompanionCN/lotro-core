package delta.games.lotro.tools.tracker.deeds;

import delta.games.lotro.character.CharacterFile;
import delta.games.lotro.character.status.achievables.AchievableStatus;
import delta.games.lotro.lore.deeds.DeedDescription;

/**
 * Proivdes 'completed' state of deeds.
 * @author DAM
 */
public class DeedCompletedTrackedDataProvider extends AbstractDeedTrackedDataProvider
{
  /**
   * Constructor.
   * @param deed Deed to use.
   * @param status Status data.
   */
  public DeedCompletedTrackedDataProvider(DeedDescription deed, MultipleToonsDeedStatus status)
  {
    super(deed,status);
  }

  @Override
  public Class<?> getValueType()
  {
    return Boolean.class;
  }

  @Override
  public Object getValue(CharacterFile input)
  {
    AchievableStatus status=getDeedStatus(input);
    if (status!=null)
    {
      return Boolean.valueOf(status.isCompleted());
    }
    return Boolean.FALSE;
  }
}
