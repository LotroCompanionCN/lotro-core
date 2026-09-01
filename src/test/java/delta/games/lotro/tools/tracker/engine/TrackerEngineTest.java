package delta.games.lotro.tools.tracker.engine;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import delta.common.utils.tables.DataTable;
import delta.games.lotro.LotroTestUtils;
import delta.games.lotro.character.CharacterFile;
import delta.games.lotro.tools.tracker.ArgNames;
import delta.games.lotro.tools.tracker.TrackedElement;
import delta.games.lotro.tools.tracker.TrackedElements;
import delta.games.lotro.tools.tracker.TrackedListsBuilder;

/**
 * Test for the tracker engine.
 * @author DAM
 */
class TrackerEngineTest
{
  @Test
  void test()
  {
    List<CharacterFile> toons=buildToonsList();
    // Survival deeds
    {
      TrackedElements elements=new TrackedListsBuilder().buildSurvivorList();
      doElements(elements,toons);
    }
    // Character basics
    {
      TrackedElements elements=new TrackedListsBuilder().buildCharacterBasics();
      doElements(elements,toons);
    }
  }

  private void doElements(TrackedElements elements, List<CharacterFile> toons)
  {
    List<TrackedElementValues> values=new ArrayList<TrackedElementValues>();
    TrackerEngine engine=new TrackerEngine();
    for(TrackedElement element : elements.getElements())
    {
      TrackedElementValues elementValues=engine.assess(element,toons);
      values.add(elementValues);
    }
    DataTable t=new DataTable();
    t.addColumn("ID",Integer.class);
    t.addColumn("Icon",String.class);
    t.addColumn("Name",String.class);
    for(CharacterFile toon : toons)
    {
      t.addColumn(toon.getName(),Boolean.class);
    }
    int row=0;
    for(TrackedElement element : elements.getElements())
    {
      t.addRow();
      TrackedElementValues elementValues=values.get(row);
      // ID
      Integer id=(Integer)element.getArgValue(ArgNames.ID);
      t.setData(row,0,id);
      // Icon
      t.setData(row,1,elementValues.getIcon());
      // Name
      t.setData(row,2,elementValues.getName());
      // Values
      for(int i=0;i<toons.size();i++)
      {
        Object value=elementValues.getValues().get(i);
        t.setData(row,i+3,value);
      }
      row++;
    }
    t.dump(System.out);
  }

  private List<CharacterFile> buildToonsList()
  {
    List<CharacterFile> ret=new ArrayList<CharacterFile>();
    LotroTestUtils utils=new LotroTestUtils();
    ret.add(utils.getToonByName("Giswald"));
    ret.add(utils.getToonByName("Meva"));
    ret.add(utils.getToonByName("Glumlug"));
    ret.add(utils.getToonByName("Kargarth"));
    ret.add(utils.getToonByName("Utharr"));
    ret.add(utils.getToonByName("Ethell"));
    ret.add(utils.getToonByName("Lorewyne"));
    ret.add(utils.getToonByName("Backstaba"));
    ret.add(utils.getToonByName("Baldegolf"));
    ret.add(utils.getToonByName("Reddeif"));
    return ret;
  }
}
